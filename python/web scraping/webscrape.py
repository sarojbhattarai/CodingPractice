from bs4 import BeautifulSoup
import requests
import csv


source = requests.get("http://nepalstock.com.np/").text
soup = BeautifulSoup(source, 'lxml')

csv_file = open('nepse.csv','w')

csv_writer = csv.writer(csv_file)
csv_writer.writerow(['Symbol', 'Values', 'Total Traded amount'])

marquee_tag = soup.find(
    'div', class_="col-xs-10 col-md-10 col-sm-12").marquee.b

for span_tag in marquee_tag('span'):
    span_tag.replace_with('')

for img_tag in marquee_tag('img'):
    img_tag.replace_with('')

symbol_list = marquee_tag.text.split('( )')

all_symbols = []
short_name = []
per_share_value = []
total_traded_amount = []
a1 = []
a2 = []
a3 = []

for symbol in symbol_list:
    symbol_name = symbol.replace(u'\xa0', u'')
    all_symbols.append(symbol_name)
all_symbols.pop()

a = len(all_symbols)

for i in range(a):
    a1.append(all_symbols[i].strip())
    a2.append(a1[i].split(' '))

for i in range(len(a1)):
    short_name.append(a2[i][0])
    per_share_value.append(a2[i][1])
    total_traded_amount.append(a2[i][3])
    csv_writer.writerow([a2[i][0],a2[i][1],a2[i][3]])
# print(total_traded_amount)
csv_file.close()
