/* List of all the header files */
#include <SoftwareSerial.h>
#include <NewPing.h>
#include <Servo.h>

/* Setting up pins for bluetooth */
SoftwareSerial BTSerial(7, 6); // RX,TX

/* MOTORS */

/* Left Motor */

int LmotorUp = 2;   /* Initialising Arduino port 2  as LmotorUp */
int LmotorDn = 3;   /* Initialising Arduino port 3  as LmotorDn */

/* Right Motor */

int RmotorUp = 4;  /* Initialising Arduino port 4 as RmotorUp */
int RmotorDn = 5;  /* Initialising Arduino port 5 as RmotorDn */


/* BLUETOOTH */

char BTInput;

int distanceL;
int distanceF;

/* SONAR & SERVO */

#define TRIG_PIN 12 
#define ECHO_PIN 11 

int times = 250; // standard delat time 

/* Reference positions in degress */
int front = 70; 
int left  = 180;

/* Creating Servo object to control motor */
Servo myservo; 

/* Maximum distance we want to ping for (in centimeters). Maximum sensor distance is capped at 400-500cm. */
#define MAX_DISTANCE 200 

/* NewPing setup of pin and maximum distance */
NewPing sonar(TRIG_PIN, ECHO_PIN, MAX_DISTANCE); 

void smoothServo()
{
	for(int i=front; i<=left; i++)
	{
		myservo.write(i);
		delay(10);
	}

	distanceL=readPing();
	delay(50);

	for(int i=left; i>=front; i--)
	{
		myservo.write(i);
		delay(10);
	}
	distanceF = readPing();
}


int readPing()
{
	delay(70);
	int cm = sonar.ping_cm();
	if (cm == 0)
	{
		cm = 250;
	}
	return cm;
}



void setup() {
	// put your setup code here, to run once:

	//set up pins for motor, serial for BT
	Serial.begin(9600);
	BTSerial.begin(9600);
	pinMode(LmotorUp, OUTPUT);
	pinMode(LmotorDn, OUTPUT);
	pinMode(RmotorUp, OUTPUT);
	pinMode(RmotorDn, OUTPUT);

	/* Attaches the servo motor on pin 10 to the myservo object */
	myservo.attach(8);  


	myservo.write(70);
}

void followLeft()
{
	smoothServo();

	if (distanceL <= 10)
	{
		turnRight();
		delay(200);
		moveForward();
		delay(300);
		turnLeft();
		delay(250);
		stopMove();
	}
	else if ((distanceL >= 10) && (distanceL < 23))
	{
		while (distanceL < 20)
		{
			if (distanceF > 13)
			{
				moveForward();
				delay(times);
				stopMove();
			}
			if (distanceF <= 13)
			{
				turnRight();
				delay(times-10);
				stopMove();
			}
			smoothServo();
		}
	}
	else if(distanceF<10){
		stopMove();
		delay(times);
		turnRight();
		delay(times*2);
		stopMove();
	}
	else
	{
		moveForward();  
		delay(times);
		turnLeft();
		delay(times);
		moveForward();
		delay(times);
		stopMove();
	}
}

//----------MOTOR INTERFACING----------
void stopMove()
{
	Serial.write("STOP");
	Serial.write('\n');
	digitalWrite(LmotorUp,LOW);
	digitalWrite(LmotorDn,LOW);
	digitalWrite(RmotorUp,LOW);
	digitalWrite(RmotorDn,LOW);  
	//  Serial.write("stopMoveafter");
	Serial.write('\n');
}



void moveForward()
{
	Serial.write("FORWARD");
	Serial.write('\n');
	digitalWrite(LmotorUp,HIGH);
	digitalWrite(LmotorDn,LOW);   
	digitalWrite(RmotorUp,HIGH);  
	digitalWrite(RmotorDn,LOW); 
	//  Serial.write("MoveForwardafter");
	Serial.write('\n');
}

void moveBackward()
{
	Serial.write("BACKWARD");
	Serial.write('\n');
	digitalWrite(LmotorUp,LOW);
	digitalWrite(LmotorDn,HIGH);   
	digitalWrite(RmotorUp,LOW);  
	digitalWrite(RmotorDn,HIGH); 
	//  Serial.write("MoveBackwardafter");
	Serial.write('\n');
}

void turnLeft()
{
	Serial.write("LEFT");
	Serial.write('\n');
	digitalWrite(LmotorUp,LOW);
	digitalWrite(LmotorDn,HIGH);   
	digitalWrite(RmotorUp,HIGH);  
	digitalWrite(RmotorDn,LOW);    
	//  Serial.write("turnLeftafter");
	Serial.write('\n');
}

void turnRight()
{
	Serial.write("RIGHT");
	Serial.write('\n');
	digitalWrite(LmotorUp,HIGH);
	digitalWrite(LmotorDn,LOW);   
	digitalWrite(RmotorUp,LOW);  
	digitalWrite(RmotorDn,HIGH);  
	//  Serial.write("turnRightafter");
	Serial.write('\n');
}

/* Main program for the robot */
/* Takes the bluetooth input and decides on an action */


void loop() 
{
	myservo.write(70);
	if (BTSerial.available() > 0)
	{
		BTInput = BTSerial.read();  

		if (BTInput == 68)  // check for the release button
		{  
			while ((BTInput == 68) || (BTInput == 48))
			{
				followLeft();
				if (BTSerial.available() > 0)
				{
					BTInput = BTSerial.read();
				}
				if(BTInput==67){
					break;
				}
			}    
		}
		else
		{

			while (BTInput == 50) // back button is pressed 
			{
				moveBackward();
				BTInput = BTSerial.read(); //update statement for while
			}
			while (BTInput == 52) // left button
			{  
				turnLeft();
				BTInput = BTSerial.read(); //update statement for while
			}
			while (BTInput == 54) // right button
			{
				turnRight();
				BTInput = BTSerial.read(); //update statement for while
			}
			while (BTInput == 48) // whilst the button is not released the car movements can take place
			{  
				stopMove();
				BTInput = BTSerial.read(); //update statement for while
			}

			while ((BTInput == 56) || (BTInput == 48)) // forward button
			{
				distanceF = readPing();
				if (distanceF >= 20) //subject to change
				{
					distanceF = readPing();
					moveForward();

				}
				if (distanceF < 20)
				{
					stopMove();
					distanceF = readPing();

				}
				if (BTSerial.available() > 0)        
				{
					BTInput = BTSerial.read(); //update statement for while
				} 
				if(BTInput==48){
					stopMove();
				}
			}

		}
	}
}