### Java Core (семинары)
#### Урок 2. Данные и функции

1. Полностью разобраться с кодом программы разработанной на семинаре, переписать программу. Это минимальная задача для сдачи домашней работы.

Усложняем задачу:

2.* Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3.**** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

***
Для решения задачи и проверки победы в общем случае, когда размер игрового поля и число фишек для 
победы могут быть различными, я использую следующую методику:

1) Создаю методы для проверки победных ситуаций по горизонталям, вертикалям и диагоналям:
    - checkHorizontal()
    - checkVertical()
    - checkDiagonal()

2) В каждом из этих методов проходим по строкам и столбцам 
с помощью циклов и проверяем, есть ли winCount последовательных фишек одного типа.

3) В методе checkWin() вызываю соответствующие методы проверки победных ситуаций.

***
При доработке "интеллекта" использую следующий подход:

1. Сначала проверить наличие предвыигрышных вариантов для компьютера. 
Если такие варианты есть, AI должен сделать свой ход в одну из этих ячеек для победы.
2. Затем проверить наличие предвыигрышных вариантов для соперника и заблокировать их, 
помещая фишку компьютера рядом с рядом фишек соперника.
3. Если первые два условия не выполнены, проверяю ходы соперника winCount-1, -2, чтобы предотвратить его потенциальную победу.
4. Также проверяю ходы AI по ряду winCount-1, -2.
5. В противном случае AI делает рандомный ход.
