package com.anna.lesson2.factorymethod;

import com.anna.lesson2.templatemethod.LogReader;

public abstract class BaseLogReaderCreator {


    public LogReader createLogReader(LogType logType, Object data){
        LogReader logReader = createLogReaderInstance(logType);
        //TODO: Выполнение подготовительных действий над объектом
        logReader.setDataSource(data);Р
        //logReader.setCurrentPosition(2);
        return logReader;
    }

    /**
     * Фабричный метод
     * @param logType тип лог-ридера
     * @return конкретный объект лог-ридера
     */
    
    protected abstract LogReader createLogReaderInstance(LogType logType);

}

