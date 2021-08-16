package views.Base;

import java.util.Collection;

public interface PageApi {

    <T> void print(T value);

    void print();

    void line();

    void jump();

    String enterValue(String msg, int minimumLength);

    String enterLine(String msg );

    String enterValue(String msg);

    int selectOpt(int maxOpt);

    <E> void printTitle(E value);

    void printTitle();

    <K> void warning(K warningMessage);

    void warning();

    <Z> void success(Z warningMessage);

    void success();

    int printOptions(Collection<String> options);

}
