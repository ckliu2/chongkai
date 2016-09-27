#include<winsock2.h>
#include<stdio.h>

int main() {
  SOCKET server_sockfd, client_sockfd;
  int server_len, client_len;
  struct sockaddr_in server_address;
  struct sockaddr_in client_address;

  // ���U Winsock DLL
  WSADATA wsadata;
  if(WSAStartup(0x101,(LPWSADATA)&wsadata) != 0) {
    printf("Winsock Error\n");
    exit(1);
  }

  // ���� server socket
  server_sockfd = socket(AF_INET, SOCK_STREAM, 0); // AF_INET(�ϥ�IPv4); SOCK_STREAM; 0(�ϥιw�]�q�T��w�A�YTCP)
  if(server_sockfd == SOCKET_ERROR) {
    printf("Socket Error\n");
    exit(1);
  }

  // struct sockaddr_in {
  //     short int               sin_family; /* AF_INT(�ϥ�IPv4) */
  //     unsigned short int sin_port;    /* Port(��) */
  //     struct in_addr       sin_addr;   /* IP��} */
  // };
  // sturct in_addr {
  //     unsigned long int s_addr;
  // };
  server_address.sin_family = AF_INET; // AF_INT(�ϥ�IPv4)
  server_address.sin_addr.s_addr = inet_addr("140.129.140.55"); // �]�wIP��}
  server_address.sin_port = 4660; //�]�w��
  server_len = sizeof(server_address);

  if(bind(server_sockfd, (struct sockaddr *)&server_address, server_len) < 0) {
    printf("Bind Error\n");
    exit(1);
  }

  if(listen(server_sockfd, 5) < 0) {
    printf("Listen Error\n");
    exit(1);
  }

  while(1) {
    char ch;
    printf("Server waiting...\n");
    client_len = sizeof(client_address);

    client_sockfd = accept(server_sockfd, (struct sockaddr *)&client_address, &client_len);
    if(client_sockfd == SOCKET_ERROR) {
      printf("Accept Error\n");
      exit(1);
    }

    recv(client_sockfd, &ch, 1, 0); // Linux socket programming �� read
    ch++;
    send(client_sockfd, &ch, 1, 0); // Linux socket programming �� write
    closesocket(client_sockfd); // Linux socket programming �� close
  }
}
