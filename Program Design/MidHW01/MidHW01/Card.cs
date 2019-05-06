using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


    public class Card
    {
        string cardId;
        int type;
        int balance;
        int count;

        public Card(string cardId, int balance, int type)
        {
            CardId = cardId;
            Balance = balance;
            Type = type;
        }

        public string CardId 
        {
            get 
            {
                return cardId;
            }
            set 
            {
                cardId = value;
            }
        }

        public int Type 
        {
            get
            {
                return type;
            }
            set
            {
                type = value;
            }
        }

        public int Balance
        {
            get
            {
                return balance;
            }
            set
            {
                if (balance > 5000)
                {
                    balance = 5000;
                }
                else if (balance < 0)
                {
                    balance = 0;
                }
                balance = value;
            }
        }
        
        public int Count
        {
            get 
            {
                return count;
            }
            set
            {
                count = value;
            }
        }

        public void DisplayCardInfo(){
            Console.WriteLine("卡片識別碼: {0}", cardId);
            Console.WriteLine("卡片類別: {0}", type);
            Console.WriteLine("卡片餘額: {0}", balance);
            Console.WriteLine("購買車票次數: {0}", count);
            Console.WriteLine("");
        }

        public void BuyTicket(int type,int balance){
            int buychoice;
            Console.WriteLine("***************");
            Console.WriteLine("1.嘉義-台北 自強號 普通票600元/優待票300元");
            Console.WriteLine("2.嘉義-高雄 自強號 普通票450元/優待票225元");
            Console.WriteLine("3.離開系統");
            Console.Write("使用者選擇項目: ");
            buychoice = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("{0}", buychoice);

            while (buychoice != 3)
            {
                if (buychoice == 1)
                {
                    if (type == 1) 
                    {
                        if (balance >= 600)
                        {
                            balance -= 600;
                            count++;
                            Console.WriteLine("");
                            Console.WriteLine("卡片餘額: {0}", balance);
                            Console.WriteLine("購買車票次數: {0}", count);
                            Console.WriteLine("");
                            Console.WriteLine("***************");
                            Console.WriteLine("1.嘉義-台北 自強號 普通票600元/優待票300元");
                            Console.WriteLine("2.嘉義-高雄 自強號 普通票450元/優待票225元");
                            Console.WriteLine("3.離開系統");
                            Console.Write("使用者選擇項目: ");
                            buychoice = Convert.ToInt32(Console.ReadLine());
                        }
                        else
                        {
                            Console.WriteLine("餘額不足!");
                            Console.WriteLine("請按enter繼續...");
                            Console.ReadLine();
                            break;
                        }
                    }else if(type == 2)
                    {
                        if (balance >= 300)
                        {
                            balance -= 300;
                            count++;
                            Console.WriteLine("");
                            Console.WriteLine("卡片餘額: {0}", balance);
                            Console.WriteLine("購買車票次數: {0}", count);
                            Console.WriteLine("");
                            Console.WriteLine("***************");
                            Console.WriteLine("1.嘉義-台北 自強號 普通票600元/優待票300元");
                            Console.WriteLine("2.嘉義-高雄 自強號 普通票450元/優待票225元");
                            Console.WriteLine("3.離開系統");
                            Console.Write("使用者選擇項目: ");
                            buychoice = Convert.ToInt32(Console.ReadLine());
                        }
                        else
                        {
                            Console.WriteLine("餘額不足!");
                            Console.WriteLine("請按enter繼續...");
                            Console.ReadLine();
                            break;
                        }
                    }
                }
                else if (buychoice == 2)
                {
                    if (type == 1) 
                    {
                        if (balance >= 450)
                        {
                            balance -= 450;
                            count++;
                            Console.WriteLine("");
                            Console.WriteLine("卡片餘額: {0}", balance);
                            Console.WriteLine("購買車票次數: {0}", count);
                            Console.WriteLine("");
                            Console.WriteLine("***************");
                            Console.WriteLine("1.嘉義-台北 自強號 普通票600元/優待票300元");
                            Console.WriteLine("2.嘉義-高雄 自強號 普通票450元/優待票225元");
                            Console.WriteLine("3.離開系統");
                            Console.Write("使用者選擇項目: ");
                            buychoice = Convert.ToInt32(Console.ReadLine());
                        }
                        else
                        {
                            Console.WriteLine("餘額不足!");
                            Console.WriteLine("請按enter繼續...");
                            Console.ReadLine();
                            break;
                        }
                    }
                    else if (type == 2)
                    {
                        if (balance >= 225)
                        {
                            balance -= 225;
                            count++;
                            Console.WriteLine("");
                            Console.WriteLine("卡片餘額: {0}", balance);
                            Console.WriteLine("購買車票次數: {0}", count);
                            Console.WriteLine("");
                            Console.WriteLine("***************");
                            Console.WriteLine("1.嘉義-台北 自強號 普通票600元/優待票300元");
                            Console.WriteLine("2.嘉義-高雄 自強號 普通票450元/優待票225元");
                            Console.WriteLine("3.離開系統");
                            Console.Write("使用者選擇項目: ");
                            buychoice = Convert.ToInt32(Console.ReadLine());
                        }
                        else
                        {
                            Console.WriteLine("餘額不足!");
                            Console.WriteLine("請按enter繼續...");
                            Console.ReadLine();
                            break;
                        }
                    }
                }
                else if (buychoice > 3)
                {
                    Console.WriteLine("請輸入1~3之間的選項!");
                    Console.WriteLine("輸入選項:");
                    buychoice = Convert.ToInt32(Console.ReadLine());
                }
            }

            if (buychoice == 3)
            {
                Console.WriteLine("您即將離開本系統!");
                Console.WriteLine("請按enter繼續...");
                Console.ReadLine();
            }
            

            }
            
        }


    


