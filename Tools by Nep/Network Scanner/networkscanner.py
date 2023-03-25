#!/usr/bin/env python
import scapy.all as scapy
import subprocess
import optparse

subprocess.call(["figlet", "NetworkScanner"])
print("\t\t\t\t\t\t by neptune0x13")

def get_arguments():
    parser = optparse.OptionParser()
    parser.add_option("-t","--target",dest="target",help="Target IP / IP range")   //Adding options
    (options ,arguments) = parser.parse_args()                                     //Making the option as an command line argument 
    return options

def scan(ip):
    arp_request = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst="ff:ff:ff:ff:ff:ff")
    arp_request_broadcast = broadcast/arp_request                                  //Creates a new packet with the ARP request packet as the payload and the Ethernet broadcast packet as the header.
    answered_list = scapy.srp(arp_request_broadcast, timeout=1, verbose=False)[0]  //Extracts the list of packets that received a response from the srp() function's return value.

    clients_list=[]
    for element in answered_list:
        client_dict = {"ip":element[1].psrc,"mac":element[1].hwsrc}
        clients_list.append(client_dict)
    return clients_list

def print_result(results_list):
    print("-----------------------------------------")
    print("IP\t\t\tMAC Address\n-----------------------------------------")
    for client in results_list:
        print(client["ip"]+"\t\t"+client["mac"])

options = get_arguments()                                                          //To obtain the command-line arguments 
scan_result = scan(options.target)                                                 //To perform the ARP scan and return the list
print_result(scan_result)                                                          //To display the IP and MAC of connected devices  
