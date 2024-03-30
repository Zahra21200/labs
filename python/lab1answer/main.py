number = int(input("Enter number to create triangle: "))

for row in range(1, number + 1):
    spaces = " " * (number - row)
    stars = "*" * row
    print(spaces + stars)
