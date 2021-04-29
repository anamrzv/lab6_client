package itmo.lab.commands;

import itmo.lab.other.Person;
import itmo.lab.other.CollectionsKeeper;
import itmo.lab.other.ServerResponse;

import java.util.LinkedList;
import java.util.List;

/**
 * Команда выводит сумму поля 'weight' всех объектов коллекции
 */
public class SumOfWeight extends Command {

    /**
     * Конструктор - создание нового объекта
     *
     * @param dc - обработчик команд
     */
    public SumOfWeight(CollectionsKeeper dc) {
        super(dc);
    }

    /**
     * Главный метод класса, запускает команду
     *
     * @param args Параметры командной строки
     * @return true/false Успешно ли завершилась команда
     */
    @Override
    public ServerResponse execute(List<String> args) {
        if (args == null) {
            LinkedList<Person> people = dc.getPeople();
            long sum = 0;
            for (Person p : people) {
                sum += p.getWeight();
            }
            return ServerResponse.builder().message(sum + " - сумма значений поля weight всех элементов коллекции").command("sum_of_weoght").build();
        } else {
            return ServerResponse.builder().error("У команды sum_of_weight нет аргументов. Введите команду еще раз.").command("sum_of_weight").build();
        }
    }

    /**
     * Возвращает имя команды
     *
     * @return имя
     */
    @Override
    public String getName() {
        return "sum_of_weight";
    }

    /**
     * Возвращает описание команды
     *
     * @return описание
     */
    @Override
    public String getDescription() {
        return "sum_of_weight : вывести сумму значений поля weight для всех элементов коллекции";
    }
}
