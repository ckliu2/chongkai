#include <windows.h>
#include <stdio.h>

#include <sys/socket.h>




int main()
{

	      

 SOCKET server_sockfd, client_sockfd;
  int server_len, client_len;
  struct sockaddr_in server_address;
  struct sockaddr_in client_address;


  // ���� server socket
  server_sockfd = socket(AF_INET, SOCK_STREAM, 0); // AF_INET(�ϥ�IPv4); SOCK_STREAM; 0(�ϥιw�]�q�T��w�A�YTCP)
  if(server_sockfd == SOCKET_ERROR) {
    printf("socket create error\n");
  }else{
 printf("socket create successful\n");
}

	      
	      
	printf("start..");
    system("pause");

}
