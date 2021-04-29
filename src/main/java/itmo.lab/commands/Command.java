package itmo.lab.commands;

import itmo.lab.other.CollectionsKeeper;
import itmo.lab.other.ServerResponse;

import java.util.List;

/**
 * Абстрактный класс - любая команда
 */
public abstract class Command {

    /**
     * Поле - обработчик команд
     */
    public CollectionsKeeper dc;

    /**
     * Конструктор - создание нового объекта
     *
     * @param dc - обработчик команд
     */
    Command(CollectionsKeeper dc) {
        this.dc = dc;
    }

    /**
     * Главный метод класса, запускает команду
     *
     * @param args Параметры командной строки
     * @return true/false Успешно ли завершилась команда
     */
    public abstract ServerResponse execute(List<String> args);

    /**
     * Возвращает имя команды
     *
     * @return имя
     */
    public abstract String getName();

    /**
     * Возвращает описание команды
     *
     * @return описание
     */
    public abstract String getDescription();
}
