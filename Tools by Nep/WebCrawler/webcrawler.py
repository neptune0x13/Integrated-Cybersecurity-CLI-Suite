import requests
import re
import urllib.parse
import subprocess

target_url = "[target url]"
target_links = []

subprocess.call(["figlet", "Web Crawler "])
print("\t\t\t\t\t\t by neptune0x13")

def extract_links_from(url):
   response = requests.get(url)
   return re.findall('(?:href=")(.*?)"', response.content.decode('utf-8'))

def crawl(url):
   href_links = extract_links_from(url)
   for link in href_links:
       link = urllib.parse.urljoin(url, link)
       
       if "#" in link:
          link = link.split("#")[0]
          
       if target_url in link and link not in target_links:
           target_links.append(link)
           print(link)
           crawl(link)
           
crawl(target_url)
