import hjelpeklasser.Beholder;

import java.util.Iterator;

public abstract class AbstraktBeholder<T> implements Beholder<T>
{
    public abstract boolean leggInn(T t);    // en abstrakt metode

    public boolean inneholder(T t)
    {
        if(t == null) {
            for(T verdi : this) {
                if(verdi == null) {
                    return true;
                }
            }
        }
        for(T verdi : this) {
            if(t.equals(verdi)) {
                return true;
            }
        }
        return false;
    }

    public boolean fjern(T t)
    {
        return false;   // foreløpig kode
    }

    public int antall()
    {
        return 0;   // foreløpig kode
    }

    public boolean tom()
    {
        return antall() == 0;   // ferdig kode
    }

    public void nullstill()
    {
        for(Iterator<T> i = this.iterator(); i.hasNext(); ) {
            i.next();
            i.remove();
        }
    }

    public abstract Iterator<T> iterator();    // en abstrakt metode

    public String toString()
    {
        return null;   // foreløpig kode
    }
}