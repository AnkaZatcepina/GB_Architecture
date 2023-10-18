package com.anna.lesson2.factorymethod;

import com.anna.lesson2.templatemethod.LogReader;
import com.anna.lesson2.templatemethod.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator {
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        if (logType==LogType.Poem) {
            return new PoemReader();
        }
        if (logType==LogType.Text) {
            return new TextFileReader();
        }
        if (logType==LogType.Database) {
            return new DatabaseReader();
        }
        if (logType==LogType.System) {
            return new OperationSystemLogEventReader();
        }
        /*return switch (logType){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DatabaseReader();
            case System -> new OperationSystemLogEventReader();
        };*/
    }
}
