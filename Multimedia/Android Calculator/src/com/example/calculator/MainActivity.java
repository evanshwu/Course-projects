package com.example.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private static final String res="0";
	
	int phase = 0;
	int a, colorcode = 0;
	int chksqrt = 0;
	double number1 = 0;
	double number2 = 0;
	double result = 0;
	String n1;
	String n2;
	String r;
	String sys;
	NumberFormat nf;
	private int dothasdef = 0;
	
	Handler mHandler;
	CharSequence ertext = "ERROR";
	private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, btncln, 
	btnplus, btnminus, btnmulti, btndivide, btnequ, btnsqrt, btndot, btnchange;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Check if application is restored from memory
		if(savedInstanceState == null){
			// Just start running
			number1 = 0;
			r = "0";
		}else{
			// Restored from memory
			tv.setText(savedInstanceState.getCharSequence(res));
		}
		
		button0 = (Button)findViewById(R.id.button10);
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		button7 = (Button)findViewById(R.id.button7);
		button8 = (Button)findViewById(R.id.button8);
		button9 = (Button)findViewById(R.id.button9);
		tv = (TextView)findViewById(R.id.textView1);
		
		btncln = (Button)findViewById(R.id.buttonclear);
		btnplus = (Button)findViewById(R.id.buttonplus);
		btnminus = (Button)findViewById(R.id.buttonminus);
		btnmulti = (Button)findViewById(R.id.buttonmulti);
		btndivide = (Button)findViewById(R.id.buttondivide);
		btnequ = (Button)findViewById(R.id.buttonequals);
		btnsqrt = (Button)findViewById(R.id.buttonsqrt);
		btndot = (Button)findViewById(R.id.buttondot);
		btnchange = (Button)findViewById(R.id.btnchange);
		
		button0.setOnClickListener(zeroButtonListener);
		button1.setOnClickListener(oneButtonListener);
		button2.setOnClickListener(twoButtonListener);
		button3.setOnClickListener(threeButtonListener);
		button4.setOnClickListener(fourButtonListener);
		button5.setOnClickListener(fiveButtonListener);
		button6.setOnClickListener(sixButtonListener);
		button7.setOnClickListener(sevenButtonListener);
		button8.setOnClickListener(eightButtonListener);
		button9.setOnClickListener(nineButtonListener);
		btncln.setOnClickListener(clearButtonListener);
		btnplus.setOnClickListener(plusButtonListener);
		btnminus.setOnClickListener(minusButtonListener);
		btnmulti.setOnClickListener(multiButtonListener);
		btndivide.setOnClickListener(divideButtonListener);
		btnequ.setOnClickListener(equalButtonListener);
		btnsqrt.setOnClickListener(sqrtButtonListener);
		btndot.setOnClickListener(dotButtonListener);
		btnchange.setOnClickListener(bgchangeButtonListener);
		
		mHandler = new Handler(){
			public void handleMessage(Message msg){
				if(msg.what==0){
					tv.setText(ertext);
				}
			}
		};
	}// end onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Save value to memory
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		
		// Save elements
		outState.putDouble(res, result);
	}// end method onSaveInstanceState
	
	public OnClickListener bgchangeButtonListener = new OnClickListener(){
		public void onClick(View v){
			// Color code, default white
			String cc = "#FFFFFF";
			// Color cycle
			switch(colorcode){
			case 0:
				cc = "#9AADFF";
				colorcode++;
				Toast.makeText(v.getContext(), "Made By HsinHanWu", Toast.LENGTH_LONG).show();
				break;
			case 1:
				cc = "#DDAD72";
				colorcode++;
				Toast.makeText(v.getContext(), "Made By HsinHanWu", Toast.LENGTH_LONG).show();
				break;
			case 2:
				cc = "#5CAC84";
				colorcode++;
				Toast.makeText(v.getContext(), "Made By HsinHanWu", Toast.LENGTH_LONG).show();
				break;
			case 3:
				cc = "#FFFFFF";
				colorcode = 0;
				Toast.makeText(v.getContext(), "Made By HsinHanWu", Toast.LENGTH_LONG).show();
				break;
			}
			
			setActivityBackgroundColor(Color.parseColor(cc));
		}
	};
	
	public OnClickListener plusButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
            	if(chksqrt ==1){
            		phase = 1;
            		btnplus.performClick();
            		break;
            	}
                number1 = 0;
                a = 1;
                phase = 2;
                break;
            case 1:
                a = 1;
                phase = 2;
                break;
            case 2:
                a = 1;
                break;
            case 3:
                result = operation(a);
                number1 = number2;
                r = nf.format(result);
                tv.setText(r);
                a = 1;
                number1 = result;
                phase = 2;
                break;
            case 4:
                number1 = result;
                number2 = result;
                n1 = nf.format(number1);
                tv.setText(n1);
                a = 1;
                phase = 33;
                break;
            }
		}
	};
	
	public OnClickListener minusButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
            	if(chksqrt ==1){
            		phase = 1;
            		btnminus.performClick();
            		break;
            	}
                number1 = 0;
                a = 2;
                phase = 2;
                break;	
            case 1:
                a = 2;
                phase = 2;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                result = operation(a);
                number1 = number2 = result;
                r = nf.format(result);
                tv.setText(r);
                a = 2;
                number1 = result;
                phase = 2;
                break;
            case 4:
                number1 = result;
                number2 = result;
                n1 = nf.format(number1);
                tv.setText(n1);
                a = 2;
                phase = 33;
                break;
            }
		}
	};
	
	public OnClickListener multiButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
            	if(chksqrt ==1){
            		phase = 1;
            		btnmulti.performClick();
            		break;
            	}
                number1 = 0;
                a = 3;
                phase = 2;
                break;
            case 1:
                a = 3;
                phase = 2;
                break;
            case 2:
                a = 3;
                break;
            case 3:
                result = operation(a);
                number1 = number2 = result;
                r = nf.format(result);
                tv.setText(r);
                a = 3;
                number1 = result;
                phase = 2;
                break;
            case 4:
                number1 = result;
                number2 = result;
                n1 = nf.format(number1);
                tv.setText(n1);
                a = 3;
                phase = 33;
                break;
            }
		}
	};
	
	public OnClickListener divideButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
            	if(chksqrt ==1){
            		phase = 1;
            		btndivide.performClick();
            		break;
            	}
                number1 = 0;
                a = 4;
                phase = 2;
                break;
            case 1:
                a = 4;
                phase = 2;
                break;
            case 2:
                a = 4;
                break;
            case 3:
                result = operation(a);
                number1 = number2 = result;
                r = nf.format(result);
                tv.setText(r);  
                a = 4;
                number1 = result;
                phase = 2;
                break;
            case 4:
                number1 = result;
                number2 = result;
                n1 = nf.format(number1);
                tv.setText(n1);
                a = 4;
                phase = 33;
                break;
            }
		}
	};
	
	public OnClickListener sqrtButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			result = operation(5);
            tv.setText(nf.format(result));
            number1 = result;
            a = 0;
            n1 = tv.getText().toString();
            //result = 0;
            phase = 0;
            chksqrt = 1;
		}
	};
	
	public OnClickListener equalButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                break;
            case 1:
                break;
            case 2:
                if(a==1){
                    //plus
                	result = number1;
                    result += number1;
                    System.out.println(result);
                    r = nf.format(result);
                    tv.setText(r);                        
                    phase = 4;
                }else if(a==2){
                    // minus
                	result = number1;
                    result -= number1;
                    r = nf.format(result);
                    tv.setText(r);
                }else if(a==3){
                    // times
                	result = number1;
                    result *= number1;
                    r = nf.format(result);
                    tv.setText(r);
                }else if(a == 4){
                    // divide
                	result = number1;
                    result /= number1;
                    r = nf.format(result);
                    tv.setText(r);
                }
                break;
            case 3:
                result = operation(a);
                number1 = result;
                r = nf.format(result);
                tv.setText(r);
                phase = 4;
                break;
            case 33:
            	number2 = number1;
            	result = operation(a);
            	r = nf.format(result);
            	tv.setText(r);
            	phase = 4;
            	break;
            case 4:
                number1 = result;
                result = operation(a);
                r = nf.format(result);
                break;
            }
		}
	};
	
	public OnClickListener clearButtonListener = new OnClickListener(){
		public void onClick(View v){
			clean();
		}
	};
	
	public OnClickListener dotButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
            	n1 = "0.";
            	dothasdef = 1;
            	break;
            case 1:
            	if(dothasdef != 1){
            		n1 = tv.getText() + ".";
                	dothasdef = 1;
            	}
            	break;
            case 2:
            	if(dothasdef != 2){
            		n2 = "0.";
            		dothasdef = 2;
            		phase = 3;
            	}
            	break;
            case 3:
            	if(dothasdef != 2){
                    n2 = tv.getText() + ".";
            		dothasdef = 2;
            	}
            	break;
            case 4:
            	clean();
            	n1 = "0.";
            	dothasdef = 1;
            	phase = 1;
            	break;
            }
		}
	};
	
	public OnClickListener zeroButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 0;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
               	 n1 += "0"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 0;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "0";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 0;
                 phase = 3;
                 break;
             case 4:
                 number1 = 0;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener oneButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 1;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                	tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "1"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 1;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                	tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "1";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 1;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
                number1 = 1;
                n1 = nf.format(number1);
                tv.setText(n1);
                // clean
                number2 = 0;
                a = 0;
                result = 0;
                phase = 1;
                break;
            }// end switch
		}
	};
	
	public OnClickListener twoButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 2;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "2"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 2;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "2";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 2;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
                 number1 = 2;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener threeButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 3;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "3"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 3;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "3";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 3;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 3;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener fourButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 4;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "4"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 4;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "4";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 4;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 4;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	
	public OnClickListener fiveButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 5;
                n1 = nf.format(number1);
                tv.setText(n1);
                // set phase to 1
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "5"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 5;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "5";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 5;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 5;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener sixButtonListener = new OnClickListener(){
		public void onClick(View v){
			switch(phase){
            case 0:
                number1 = 6;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "6"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 6;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "6";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 6;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 6;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener sevenButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 7;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "7"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 7;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "7";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 7;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 7;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener eightButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 8;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "8"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 8;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "8";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 8;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 8;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};
	
	public OnClickListener nineButtonListener = new OnClickListener(){
		public void onClick(View v){
			nf = new DecimalFormat("####.####");
			switch(phase){
            case 0:
                number1 = 9;
                n1 = nf.format(number1);
                tv.setText(n1);
                phase = 1;
                break;
            case 1:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n1);
                    sys = "";
                }else if(sys.length()<8){
                    n1 += "9"; 
                    tv.setText(n1);
                    number1 = Double.parseDouble(n1);
                    sys = "";
                }// exit check max length
                break;
            case 2:
                number2 = 9;
                n2 = nf.format(number2);
                tv.setText(n2);
                phase = 3;
                break;
            case 3:
                sys = tv.getText().toString();
                // check length
                if(sys.length()>8){
                    tv.setText(n2);
                    sys = "";
                }else if(sys.length()<8){
                    n2 += "9";
                    tv.setText(n2);
                    number2 = Double.parseDouble(n2);
                    sys = "";
                }// exits check max length
                break;
             case 33:
                 number2 = 9;
                 tv.setText(nf.format(number2));
                 phase = 3;
                 break;
             case 4:
            	 number1 = 9;
                 n1 = nf.format(number1);
                 tv.setText(n1);
                 // clean
                 number2 = 0;
                 a = 0;
                 result = 0;
                 phase = 1;
                 break;
             }// end switch
		}
	};

	
	public double operation(int a){
		double rtn = 0;
		if(a==1){
	    	rtn = number1 + number2;
		}else if(a == 2){
			rtn = number1 - number2;
		}else if(a == 3){
			rtn = number1 * number2;
		}else if(a == 4){
			if(number2 == 0){
				erhandle();
			}else{
				rtn = number1/number2;
			}
		}else if(a == 5){
			rtn = Math.sqrt(number1);
		}
		return rtn;
	}
	
	public void clean(){
		// Slaughterhouse
	    number1 = 0;
	    number2 = 0;
	    phase = 0;
	    a = 0;
	    dothasdef = 0;
	    tv.setText("0");
	}
	
	
	public void erhandle(){
		clean();
		updateTextView("Error");
	}
	
	public void updateTextView(CharSequence text){
		mHandler.sendEmptyMessage(0);
	}
	
	public void setActivityBackgroundColor(int color){
		View view = this.getWindow().getDecorView();
		view.setBackgroundColor(color);
	}
}
