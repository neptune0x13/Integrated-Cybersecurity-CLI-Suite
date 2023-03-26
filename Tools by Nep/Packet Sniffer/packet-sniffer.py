#!/usr/bin/env python

import scapy.all as scapy
from scapy.layers import http
import subprocess
import optparse

subprocess.call(["figlet", "Packet Sniffer"])
print("\t\t\t\t\t\t by neptune0x13")

def get_arguments():
    parser = optparse.OptionParser()
    parser.add_option("-i","--interface",dest="iface",help="Interface to Sniff packets from")
    (options ,arguments) = parser.parse_args()
    if not options.iface:
        parser.error("[-] Please specify the Interface , use --help for more info ")
    return options


def sniff(interfacce):
    scapy.sniff(iface=interfacce, store=False, prn=sniffed_packet) #prn calls another function for every sniffed packet

def sniffed_packet(packet):
    if packet.haslayer(http.HTTPRequest):
        url = packet[http.HTTPRequest].Host + packet[http.HTTPRequest].Path
        print("[+] HTTP Request : "+ str(url))
        if packet.haslayer(scapy.Raw):
            print(packet[scapy.Raw].load)                       #This field can be changed according to needful info

options = get_arguments()
sniff(options.iface)