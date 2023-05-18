package cz.kaduch;

public class Calculator {
    private double gravityConstant;

    public Calculator(double gravityConstant) {
        this.gravityConstant = gravityConstant;
    }

    public void volnyPad(double height, double time) {
        double v = gravityConstant * time; // v=g*t
        double s = (gravityConstant * Math.pow(time, 2)) / 2; // s=1/2*g*t^2
        double t2 = height / (0.5 * gravityConstant); // t^2= 2s/g
        t2 = Math.sqrt(t2);
        t2 = (double) Math.round(t2 * 10000) / 10000;
        System.out.println("těleso má rychlost " + v + "m v čase t= " + time + "s");
        System.out.println("těleso urazilo dráhu " + s + "m za čas t= " + time + "s");
        System.out.println("těleso dopadne na zem za " + t2 + "s");
    }

    public void vodorovnyVrh(double initialVelocity, double height, double time) {
        if (initialVelocity < 0) {
            System.out.println("počateční rychlost nemuže byt 0 ani menší");
            return;
        }
        System.out.println("----------------VODOROVNÝ--------------");
        double vx = initialVelocity; // vx = v0
        double x = initialVelocity * time; // x = v0 * t
        System.out.println("rychlost Vx= " + vx);
        System.out.println("pozice x= " + x);

        System.out.println("----------------SVISLÝ--------------");
        double vy = gravityConstant * time; // vy = g * t
        vy = (double) Math.round(vy * 100) / 100;
        double y = height - 0.5 * gravityConstant * Math.pow(time, 2); // y = h - 1/2 g*t^2
        y = (double) Math.round(y * 100) / 100;
        System.out.println("rychlost Vy= " + vy);
        System.out.println("pozice y= " + y);
        if (y < 0) System.out.println("!!!!Y POZICE JE POD POVRCHEM!!!!");
        System.out.println("----------------VYSLEDNICE--------------");
        double vyslednice = vx * vx + vy * vy;
        vyslednice = Math.sqrt(vyslednice);
        vyslednice = (double) Math.round(vyslednice * 1000) / 1000;
        System.out.println("vyslednice rychlostí je " + vyslednice);

    }

    public void sikmyVrh(int angle, double initialVelocity, double initialHeight, double time) {
        System.out.println("----------------VODOROVNÝ--------------");
        double vx = initialVelocity * Math.cos(Math.toRadians(angle)); // vx = v0 * cos(a)
        double x = initialVelocity * Math.cos(Math.toRadians(angle)) * time; // x = v0 * cos(a) * t
        x= (double) Math.round(x * 1000) /1000;
        vx= (double) Math.round(vx * 1000) /1000;
        System.out.println("rychlost vx= " + vx);
        System.out.println("pozice x= " + x);
        System.out.println("----------------SVISLÝ--------------");
        double vy = initialVelocity * Math.sin(Math.toRadians(angle)) - gravityConstant * time; // vy = v0 x sin(a) - g * t
        // y = h0 + v0 * sin(a) * t - (g*t^2) /2
        double y = initialHeight + initialVelocity * Math.sin(Math.toRadians(angle)) * time - (gravityConstant * time * time) / 2;
        vy= (double) Math.round(vy * 1000) /1000;
        y= (double) Math.round(y * 1000) /1000;
        System.out.println("rychlost vy= " + vy);
        System.out.println("pozice y= " + y);
        System.out.println("---------------MAX VYŠKA----------");
        double t = initialVelocity * Math.sin(Math.toRadians(angle))/gravityConstant; // t = (v0 x sin(a))/g
        // y = h0 + v0 * sin(a) * t - (g*t^2) /2 za t dosazuji t co jsem vypočítal před chvíli
        double ymax = initialHeight + initialVelocity * Math.sin(Math.toRadians(angle)) * t - (gravityConstant * t * t)/2;
        t= (double) Math.round(t * 1000) /1000;
        ymax= (double) Math.round(ymax * 1000) /1000;
        System.out.println("čas kdy dosáhne max výšku "+t);
        System.out.println("maximalní výška ymax= "+ymax);
        System.out.println("----------------DOLET----------");
        double c = initialHeight;
        double b = initialVelocity * Math.sin(Math.toRadians(angle));
        double a = - gravityConstant/2;
        double x1= (-b + Math.sqrt(b*b-4*a*c))/(2*a);
        double x2= (-b - Math.sqrt(b*b-4*a*c))/(2*a);
        double xtime= Math.max(x1,x2);
        // byl vypočet kvadraticé rovnice a vyšel mi čas  0 = h0 +v0 * sin(a) * t - (g*t^2)/2
        double xmax= initialVelocity * Math.cos(Math.toRadians(angle)) * xtime;
        xtime= (double) Math.round(xtime * 1000) /1000;
        xmax= (double) Math.round(xmax * 1000) /1000;
        System.out.println("čas kdy dopadne "+xtime);
        System.out.println("vzdálest kde dopadne "+xmax);

    }
}
