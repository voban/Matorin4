import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владимир on 10.11.2016.
 */
public interface CountMap<T> {

    // добавляет элемент в этот контейнер.
    void add(T o);

    //Возвращает количество добавлений данного элемента
    int getCount(T o);

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    int remove(T o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
    void addAll(CountMap<T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map destination);

}
