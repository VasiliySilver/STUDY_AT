# номара этажей
buildings = [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# разрешенные этажи
access_buildings = [-1, 1, 2,3, 5, 7, 9]

def go_floor(user):
    if user in access_buildings:
        print("Едем")
        return True
    else:
        print("Не едем")
        return False
while True:
    # Пользователь вводит номер этажа
    try:
        user = int(input("Введи этаж: "))
        go_floor(user)
    except ValueError:
        print("Что ты делаешь с моим мозгом!")
