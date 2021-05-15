#!/usr/bin/env python

import subprocess

a_file = open("nametag.txt")
lines = a_file.readlines()
for line in lines:
    print(line,end='╯')
a_file.close()
interface = input("Interface>")
new_mac =input("MAC address>")
print("[+] Changing MAC address for: "+ interface +" to "+ new_mac)
subprocess.call("ifconfig " + interface + " down ", shell=True)
subprocess.call("ifconfig " + interface + " hw ether "+new_mac, shell=True)
subprocess.call("ifconfig " + interface + " up ", shell=True)
