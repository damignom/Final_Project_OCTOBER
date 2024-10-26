//console.log('Hello');


/*=====Carousel====*/
let currentSlide = 0;

function showSlide(index) {
    const slides = document.querySelectorAll('.carousel-images img');

    if (index >= slides.length) {
        currentSlide = 0;
    } else if (index < 0) {
        currentSlide = slides.length - 1;
    } else {
        currentSlide = index;
    }

    const offset = -currentSlide * 100; // Сдвиг в процентах
    document.querySelector('.carousel-images').style.transform = `translateX(${offset}%)`;
}

function moveSlide(direction) {
    showSlide(currentSlide + direction);
}

// Показать первый слайд при загрузке страницы
showSlide(currentSlide);

/*=====Photo Editor====*/

document.getElementById('upload').addEventListener('change', function(event) {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = function(e) {
        const img = document.getElementById('image');
        img.src = e.target.result;
        img.style.display = 'block'; // Показываем изображение
    };

    if (file) {
        reader.readAsDataURL(file); // Читаем файл как URL
    }
});

document.getElementById('resize').addEventListener('input', function(event) {
    const sizeValue = event.target.value;
    const img = document.getElementById('image');

    img.style.width = sizeValue + '%'; // Изменяем ширину изображения
    document.getElementById('size-value').textContent = sizeValue + '%'; // Обновляем отображаемый размер
});