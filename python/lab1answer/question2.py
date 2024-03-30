number = int(input("Enter a number: "))
multiplcationTables = []

for i in range(1, number + 1):
    table = []
    for j in range(1, i + 1):
        multiplcationNumber = i * j
        table.append(multiplcationNumber)
    multiplcationTables.append(table)
print(multiplcationTables)
