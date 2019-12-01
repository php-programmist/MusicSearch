# Мобильное приложение Android для поиска исполнителей на ITunes
Данное приложение позволяет осуществлять поиск музыкальных исполнителей с помощью [API Apple Music](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/).
При вводе поискового запроса происходит автоматическое обращение к API, но только после короткого промежутка времени, когда пользователь перестал вводить буквы (debounce).
Debounce реализован с помощью [Coroutines](https://kotlinlang.ru/docs/reference/coroutines.html)
При первом запросе возвращается до 50 возможных исполнителей. При прокрутке вниз происходит автоматическая подгрузка следующих 50 исполнителей.
Подгрузка данных реализована за счет [Paging library](https://developer.android.com/topic/libraries/architecture/paging)
При клике по одному из исполнителей, происходит переход на экран исполнителя, где отображается горизонтальный список 10 популярных альбомов с обложками и вертикальный список 10 популярных песен
### Используемые библиотеки и архитектурные компоненты:
1. [Retrofit 2](https://github.com/square/retrofit) для получения JSON c сервера
2. [Moshi](https://github.com/square/moshi) для преобразования JSON в объекты
3. [Paging library](https://developer.android.com/topic/libraries/architecture/paging) для подгрузки данных при пролистывании вниз
4. [Coroutines](https://kotlinlang.ru/docs/reference/coroutines.html) для создания Debounce
5. [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
6. [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
7. [Picasso](https://github.com/square/picasso) для загрузки и кэширования изображений
