#include <iostream>
using namespace std;
class Time
{
    int day, hour, min, sec;

public:
    Time(int day, int hour, int min, int sec)
    {
        this->day = day;
        this->hour = hour;
        this->min = min;
        this->sec = sec;
    }

    Time operator/(Time &t)
    {
        int s = this->sec + t.sec;
        int m = this->min + t.min + s / 60;
        s %= 60;
        int h = this->hour + t.hour + m / 60;
        m %= 60;
        int d = this->day + t.day + h / 24;
        h %= 24;
        return Time(d, h, m, s);
    }

    void display()
    {
        cout << "day " << day << " hour " << hour << " minute " << min << " seconds " << sec << endl;
    }
};
int main()
{
    int d1, d2, h1, h2, m1, m2, s1, s2;
    cin >> d1 >> h1 >> m1 >> s1;
    cin >> d2 >> h2 >> m2 >> s2;
    Time t1(d1, h1, m1, s1);
    Time t2(d2, h2, m2, s2);
    t1.display();
    t2.display();
    cout << "Result is " << endl;
    Time t3 = t1 / t2;
    t3.display();

    return 0;
}

// unary operator overloading ++Num,Num++,- -> +, --Num,Num--
// Binary Operator Overloading