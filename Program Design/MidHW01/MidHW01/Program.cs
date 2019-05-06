using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("請輸入卡片識別碼: ");
            string cardId = Convert.ToString(Console.ReadLine());
            Console.WriteLine("請輸入卡片類別(1.一般票；2.優待票)：");
            int type = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("請輸入卡片儲值金額：");
            int balance = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("");

            Card normal = new Card(cardId, balance, type);
            Card special = new Card(cardId, balance, type);

            if (type == 1)
            {
                normal.DisplayCardInfo();
                normal.BuyTicket(type, balance);
            }
            else if (type == 2)
            {
                special.DisplayCardInfo();
                special.BuyTicket(type, balance);
            }
            else
            {
                Console.WriteLine("Type should be 1 or 2 !!!");
                Console.ReadLine();
            }

            
        }
    }

