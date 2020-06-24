from matplotlib import pyplot as plt
import csv
plt.style.use("fivethirtyeight")
Symbol = []
Values = []
with open('nepse.csv') as csv_file:
    csv_reader = csv.DictReader(csv_file)
    for row in csv_reader:
        Symbol.append(row['Symbol'])
        Values.append(row['Values'])
print(Values[:10])

plt.bar(Symbol,Values)
plt.title("NEPSE")
plt.xlabel("Symbol")
plt.ylabel("Values")

plt.tight_layout()

plt.show()