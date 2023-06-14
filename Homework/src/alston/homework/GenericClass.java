package alston.homework;

public class GenericClass<T> {
    // 下列 t 的成員變數、方法形參及返回值的型別為 T,
    // T的型別由外部指定
    private T t;

    public GenericClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
