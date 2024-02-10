// Файл сборки верхнего уровня, в который можно добавить параметры конфигурации, общие для всех подпроектов/модулей.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
}