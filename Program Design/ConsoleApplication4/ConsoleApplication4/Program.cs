using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

    class Program
    {
        static void Main(string[] args)
        {
            //403530026 吳信翰 資管一
            Random generateNum1 = new Random(Guid.NewGuid().GetHashCode());//create two randoms
            Random generateNum2 = new Random(Guid.NewGuid().GetHashCode());//I used gethashcode to generate different numbers in a short period of time
            Random anschoise = new Random(Guid.NewGuid().GetHashCode());//create a random to choose ansers 

            //a little starting words and my copyright:))
            Console.WriteLine("Wellcome.");
            Console.WriteLine("*******This program is made by HSIN HAN WU, copyright reserved.*******");
            Console.WriteLine("");

            //a start for the main program 
            for (int i = 0; i < 99999; i++)
            {
                int number1 = generateNum1.Next(9);//generate two numbers of random everytime
                int number2 = generateNum2.Next(9);
                int ansC = anschoise.Next(100);//I set 100 to make sure the answers are random enough

                Console.WriteLine("How much is " + number1 + " times " + number2 + " ?");
                Console.WriteLine("Enter your answer:(enter -1 to exit)");
                int input = Convert.ToInt32(Console.ReadLine());//an integer of user input
                int result = (number1 * number2) - input;//an integer to check if the user is correct(0) or not(not 0)
                
            Exit:
                if (input < 0)//an exit to leave the system
                {
                    Console.WriteLine("");
                    Console.WriteLine("You choose to leave the system.");
                    Console.WriteLine("*******LEAVING SYSTEM*******");
                    Console.WriteLine("Press enter to continue");//just to keep the words exist unless user press enter
                    Console.ReadLine();
                    break;
                }

                switch (result)//start with the switch part
                {
                    case 0://if user is correct, the result will be 0
                        if (ansC <= 25)//
                         {
                            Console.WriteLine("Very Good!");
                            Console.WriteLine("");
                        }
                        else if (ansC >= 26 && ansC <= 50)
                        {
                            Console.WriteLine("Excellent!");
                            Console.WriteLine("");
                        }
                        else if (ansC >= 51 && ansC <= 75)
                        {
                            Console.WriteLine("Nice work!");
                            Console.WriteLine("");
                        }
                        else
                        {
                            Console.WriteLine("Keep up the good work!");
                            Console.WriteLine("");
                        }
                        break;
                   
                    default: //if user is incorrect, the result will not be 0
                        if (ansC <= 25)
                            {
                                Console.WriteLine("No. Please try again.");
                                Console.WriteLine("");
                                while (result != 0) 
                                {
                                    Console.WriteLine("");
                                    Console.WriteLine("Enter your answer:(enter -1 to exit)");
                                    input = Convert.ToInt32(Console.ReadLine());
                                    result = (number1 * number2) - input;
                                    if (input == -1)
                                    {
                                        goto Exit;
                                    }
                                }
                            }
                            else if (ansC >= 26 && ansC <= 50)
                            {
                                Console.WriteLine("Wrong. Try once more.");
                                Console.WriteLine("");
                                while (result != 0)
                                {
                                    Console.WriteLine("");
                                    Console.WriteLine("Enter your answer:(enter -1 to exit)");
                                    input = Convert.ToInt32(Console.ReadLine());
                                    result = (number1 * number2) - input;
                                    if (input == -1)
                                    {
                                        goto Exit;
                                    }
                                }
                            }
                            else if (ansC >= 51 && ansC <= 75)
                            {
                                Console.WriteLine("Don't give up!");
                                Console.WriteLine("");
                                while (result != 0)
                                {
                                    Console.WriteLine("");
                                    Console.WriteLine("Enter your answer:(enter -1 to exit)");
                                    input = Convert.ToInt32(Console.ReadLine());
                                    result = (number1 * number2) - input;
                                    if (input == -1)
                                    {
                                        goto Exit;
                                    }
                                }
                            }
                            else
                            {
                                Console.WriteLine("No. Keep trying.");
                                Console.WriteLine("");
                                while (result != 0)
                                {
                                    Console.WriteLine("");
                                    Console.WriteLine("Enter your answer:(enter -1 to exit)");
                                    input = Convert.ToInt32(Console.ReadLine());
                                    result = (number1 * number2) - input;
                                    if (input == -1)
                                    {
                                        goto Exit;
                                    }
                                }
                            }
                            break;
                        
                }
                
                

            }

        }

    }

