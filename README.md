# Integrated Cybersecurity CLI Suite
A CLI Suite full of open source tools for security researchers

## Requirements 
  - [scapy](https://scapy.readthedocs.io/en/latest/) 
  - [optparse](https://docs.python.org/3/library/optparse.html)
  - [NetfilterQueue](https://pypi.org/project/NetfilterQueue/)
## ARP Spoofer
   This tool can be used to send falsified ARP messages to associate your own MAC address with the IP address of your another computer, 
   causing traffic intended for that device to be sent to the your computer instead. It uses the Scapy library to construct and send ARP packets to the target and 
   router, and also includes a restore function to reset the ARP tables on the target and router after the attack has completed. 
   (Strongly recommend using a macchanger along with this tool).

## Macchanger
   This tool allows users to change the MAC addresses of a network interfaces on a Linux system. Its uses the subprocess module to execute commands in the shell 
   to bring down the specified interface, change the MAC address to the specified value, and bring the interface back up. You can specify the interface to change 
   the MAC address for and the new MAC address to set. 

## Network Scanner
   This tool performs network scan using the ARP protocol. It uses the Scapy library to send ARP requests to the specified IP address or range, and then 
   listens for responses from the devices on the network. It then prints out a list of the IP addresses and corresponding MAC addresses of the devices that responded 
   to the ARP request. This tool can be useful for quickly identifying devices on a network and checking for any unauthorized devices or potential security issues.

## Packet Sniffer
   This tool  allows the user to sniff packets on a specific network interface and can extract HTTP request URLs and payload data from packets that have the
   appropriate layers. It uses the optparse module to allow the user to specify the interface to sniff on. This tool can be useful for network administrators and 
   security professionals to monitor and analyze network traffic

## File Interceptor
   This tool allows the interception and modification of HTTP download requests within a local network. By capturing the network traffic, File Interceptor identifies 
   the download requests being made by other computers on the same network. It then provides the ability to replace the intended file with a different file of choice,
   effectively altering the download destination.

## How to run the program?
1. **Download this GitHub repository**
	- Either Clone the repository
		```
		git clone https://github.com/neptune0x13/Cybersecuirty-Tool-Kit.git
		```
	- Or download and extract the zip archive of the repository.

2. **Download & Install requirements**
	- Ensure that you have Python 3 installed.
	- Open terminal in the Repository folder on your local machine.
	- Run the following command to install requirements.
		```
		pip3 install -r requirements.txt
 		```
3. **To Run CLI app**
   
   **ARP Spoofer**
		
		python3 'Tools by Nep/ARP Spoofer/arp-spoofer.py' -t [target ip address] -g [router ip address]
   **Macchanger**
		
		python3 'Tools by Nep/Macchanger/Macchanger.py' -i [interface] -m [new MAC address]
   **Network Scanner** 
                
		python3 'Tools by Nep/Network Scanner/networkscanner.py' -t [target IP/ IP range}
   **Packet Sniffer**
                
		python3 'Tools by Nep/Packet Sniffer/packet-sniffer.py' -i [interface]
   **File Interceptor**
                
		python3 'Tools by Nep/FileInterceptor/file_interceptor.py'
	- Edit file type and site to download the replaced file in the python file before running

All these tools should only be used on networks with proper authorization and in compliance with applicable laws and regulations.
