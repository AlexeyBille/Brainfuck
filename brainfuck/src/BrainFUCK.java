import java.io.*;

public class BrainFUCK {
    public static void main(String[] args) throws IOException {
        char values[] = new char[30000];

        int j = 0;

        System.out.print("Путь к файлу: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filePath = br.readLine();
        String commands = "";

        try(FileInputStream fin=new FileInputStream(filePath))
        {
            System.out.println("Размер файла: " + fin.available() + " байт(а)");

            int i = -1;
            while((i=fin.read())!=-1){

                commands = commands + (char)i;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        int brc = 0;

        for(int i = 0; i < commands.length(); i++){
            switch (commands.charAt(i)) {
                case '>':
                    j++;
                    break;
                case '<':
                    j--;
                    break;
                case '+':
                    values[j]++;
                    break;
                case '-':
                    values[j]--;
                    break;
                case '.':
                    System.out.print(values[j]);
                    break;
                case ',':
                    System.out.print("Читаю строку в ячейку " + j + " : ");
                    values[j] = br.readLine().charAt(0);
                    break;
                case '[':
                        if(values[j] == 0)
                        {
                            ++brc;
                            while(brc != 0)
                            {
                                ++i;
                                if (commands.charAt(i) == '[') ++brc;
                                if (commands.charAt(i) == ']') --brc;
                            }
                        }else continue;
                case ']':
                    if(values[j] == 0)
                    {
                    }
                    else
                    {
                        if(commands.charAt(i) == ']') brc++;
                        while(brc != 0)
                        {
                            i--;
                            if(commands.charAt(i) == '[') brc--;
                            if(commands.charAt(i) == ']') brc++;
                        }
                        i--;
                    }

                }
            }
        }


    }


