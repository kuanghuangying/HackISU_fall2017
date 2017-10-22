import bs4
from bs4 import BeautifulSoup
import requests

url = 'https://www.usnews.com/best-colleges/rankings/national-universities'

r = requests.get("https://www.educationcorner.com/college-rankings.html")

data = r.text

page_soup = BeautifulSoup(data, "html.parser")

top_colleges = []

h_found = False

print ("{ ")

for link in page_soup.find_all('a'):
	s = link.get('href')
	if (s == 'harvard-university.html'):
		h_found = True
	if (s != None and len(s) > 4 and s[-5:] == '.html' and h_found):
		s = s.replace('-',' ')
		s = s[:-5]
		print("\"" + s + "\", ")

print ("}")

