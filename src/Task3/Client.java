package Task3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request;
        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Выберите пункт меню: \n 1 - добавить студента \n 2 - отчислить студента \n " +
                        "3 - вывести список группы \n 0 - выход");
                request = scanner.nextLine();
                if ("0".equals(request)) break;
                dataOutputStream.writeUTF(request);
                System.out.println("Получили от сервера ответ: " + dataInputStream.readUTF());

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }
}
