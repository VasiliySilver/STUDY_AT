[вернуться назад](/Day1)
# Задание

>1. Есть программа, которая принимает с консоли три числа a, b, c
и возвращает действительные корни уравнения a*x^2+b*x+c=0.
Какие тест кейсы вы бы предложили для тестирования такой программы?
Какие вопросы вы бы задали аналитику перед разработкой тест-кейсов?

---

### Тест-кейсы:
***

- Если D>0, то уравнение имеет два корня, которые находятся по формулам:

x1 = -b+sqrt(D)/2a

x2 = -b-sqrt(D)/2a

Пусть:
a = 1
b = -3
c = 2

x1 = 1
x2 = 2

- если дискриминант D = (b^2 - 4ac) = 0 программа должна вывести  ТОЛЬКО одно решение
b^2 = 4ac
a = 1 b = 2 c = 1

тогда должен вернуть только ОДИН корень, а не 2

x = -b/2a = -1

- если дискриминант < 0 то программа должна вывести то что решения нету
1) ДО КАКОГО ЗНАКА ПОСЛЕ ЗАПЯТОЙ ДОЖНЫ ВОЗВРАЩАТЬ

### Вопросы аналитику при создании тест кейсов:
***

- Если a = 0: xто возвращать:
1) Решить простое уравление b*x + c = 0

- При случае когда D < 0 что он должен вернуть,
1) вызывать исключения
2) возвращать константу типа Null
3) возвращал какую-то строку
4) возвращал какой-либо массив (пустой)
- При случае когда D = 0 нужно возвращать
1) массив размера 1
2) просто число
3) массив где первое значение корень а второе  Null
- При случае когда D > 0 что должен вернуть
1) массив двух чисел
2) объект который имеет свойства obj.x1 и obj.x2
3) какими типами должны быть корни если java float или double
4) ДО КАКОГО ЗНАКА ПОСЛЕ ЗАПЯТОЙ ДОЛЖНЫ ВОЗВРАЩАТЬ

[вернуться назад](/Day1)
