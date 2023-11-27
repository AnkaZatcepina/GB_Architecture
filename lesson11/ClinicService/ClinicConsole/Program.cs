using ClinicServiceNamespace;

namespace ClinicConsole
{

    partial class Program
    {

    }

    partial class Program
    {
        static void DoProcess()
        {

        }

    }

    partial class Program
    {

    }

    partial class Program
    {

    }

    internal partial class Program
    {
        static void Main(string[] args)
        {

            DoProcess();
            Console.WriteLine("Нажмите на любую клавишу для загрузки данных ...");
            Console.ReadKey();


            ClinicClient clinicClient = new ClinicClient("http://localhost:5115/", new HttpClient());

            String result;
            bool exit = false;
            while (!exit)
            {
                Console.WriteLine("Выберите пункт меню:");
                Console.WriteLine("0 - завершить работу приложения");
                Console.WriteLine("1 - добавить клиента");
                Console.WriteLine("2 - изменить Документ");
                Console.WriteLine("3 - удалить клиента");
                Console.WriteLine("4 - вывести список");
                String menu = Console.ReadLine();
                switch (menu)
                {
                    case "0":
                        exit = true;
                        break;
                    case "1":
                        CreateClientRequest createClient = new CreateClientRequest();

                        Console.WriteLine("Введите Фамилию: ");
                        createClient.SurName = Console.ReadLine(); 
                        Console.WriteLine("Введите Имя: ");
                        createClient.FirstName = Console.ReadLine();
                        Console.WriteLine("Введите Отчесво: ");
                        createClient.Patronymic = Console.ReadLine();
                        Console.WriteLine("Введите Дату рождения в формате дд/мм/гггг: ");
                        DateTime dateTime = new DateTime();
                        DateTime.TryParseExact(Console.ReadLine(), "dd/MM/yyyy",System.Globalization.CultureInfo.InvariantCulture, System.Globalization.DateTimeStyles.AdjustToUniversal,out dateTime);
                        dateTime = DateTime.SpecifyKind(dateTime, DateTimeKind.Utc);
                        createClient.Birthday = dateTime;
                        Console.WriteLine("Введите Документ ");
                        createClient.Document = Console.ReadLine();
  
                        clinicClient.CreateAsync(createClient);
                        int created = clinicClient.CreateAsync(createClient).Result;
                        if (created <= 0)
                        {
                            Console.WriteLine("Не удалось");     
                        }  else {
                            Console.WriteLine("Клиент создан");                            
                        }
                        break;
                    case "2":                        
                        Console.WriteLine("Введите ID клиента:");                     
                        int clienId = Int32.Parse(Console.ReadLine());
                        Client readClient = clinicClient.GetAsync(clienId).Result;
                        Console.WriteLine("Введите новый документ:");                     
                        String document = Console.ReadLine();

                        UpdateClientRequest updateClient = new UpdateClientRequest();
                        updateClient.ClientId = readClient.ClientId;
                        updateClient.SurName = readClient.SurName;
                        updateClient.FirstName = readClient.FirstName;
                        updateClient.Patronymic = readClient.Patronymic;
                        updateClient.Birthday = readClient.Birthday;
                        updateClient.Document = document;
                        int edited = clinicClient.EditAsync(updateClient).Result;
                        if (edited <= 0)
                        {
                            Console.WriteLine("Не удалось");     
                        }  else {
                            Console.WriteLine("Клиент изменён");                            
                        }
                        break;
                    case "3":
                        Console.WriteLine("Введите ID клиента:");    
                        clienId = Int32.Parse(Console.ReadLine());                 
                        int deleted = clinicClient.DeleteAsync(clienId).Result;
                        if (deleted <= 0)
                        {
                            Console.WriteLine("Не удалось");     
                        }  else {
                            Console.WriteLine("Клиент удалён");     
                        
                        }
                        break;
                    case "4":
                        List<Client> clients = clinicClient.ClientGetAllAsync().Result.ToList();
                        foreach (Client client in clients)
                        {   
                            Console.WriteLine("ID: " + client.ClientId);
                            Console.WriteLine("Фамилия: " + client.SurName);
                            Console.WriteLine("Имя: " + client.FirstName);
                            Console.WriteLine("Отчество: " + client.Patronymic);
                            Console.WriteLine("Дата рождения: " + client.Birthday.DateTime);
                            Console.WriteLine("Документ: " + client.Document);
                            Console.WriteLine();
                        }
                        break;
                }     
            }
        }
    }
}