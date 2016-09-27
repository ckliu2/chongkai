#include <windows.h>
#include <stdio.h>

#include <sys/socket.h>




int main()
{

	      

 SOCKET server_sockfd, client_sockfd;
  int server_len, client_len;
  struct sockaddr_in server_address;
  struct sockaddr_in client_address;


  // 產生 server socket
  server_sockfd = socket(AF_INET, SOCK_STREAM, 0); // AF_INET(使用IPv4); SOCK_STREAM; 0(使用預設通訊協定，即TCP)
  if(server_sockfd == SOCKET_ERROR) {
    printf("socket create error\n");
  }else{
 printf("socket create successful\n");
}

	      
	      
	printf("start..");
    system("pause");

}
