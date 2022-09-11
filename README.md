# Завдання з алгоритмів 

3) Для зберігання кількості унікальних за зростом людей дял кожної вагової категорії найзручніше було б використати Map, але для цього завдання використаємо список пар,
що зберігатиме значення ваги та кількості унікальних людей для кожної. Для пошуку вже у відсортованому маисиві необхідно пройти список в одному ціклі, отже маємо лінійну 
складність. Сортування потребує n*log(n) операцій, отже маємо n*log(n) + n => O(n) = n*log(n)


Додатково. На лінійну складність можна вийти у випадку, коли використовуватимо RadixSort для сортування за віком. 