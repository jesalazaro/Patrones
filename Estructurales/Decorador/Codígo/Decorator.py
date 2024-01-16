import abc
from FileUtil import *
from Factories import *


class Logger:
    __metaclass__ = abc.ABCMeta 

    def log(self, msg):
        raise NotImplementedError() 


# End of class

class ConsoleLogger(Logger):
    def log(self, msg):
        print(msg)


# End of class

class FileLogger(Logger):
    __logger = None
    def log(self, msg):
        futil = FileUtil()
        futil.writeToFile("log.txt", msg, True, True)


    def getFileLogger():
        if not FileLogger.__logger:
            FileLogger.__logger= FileLogger()
        return FileLogger.__logger

    getFileLogger: staticmethod = staticmethod(getFileLogger)
# End of class
class LoggerDecorator(Logger):
    def __init__(self, logger):
        self._logger = logger

    def log(self, dataLine):
        # Default implementation
        # to ve overriden by subclasses.
        self._logger.log(dataLine)
# End of class
class EncryptLogger(LoggerDecorator):
    def __init__(self, logger):
        LoggerDecorator.__init__(self, logger)

    def log(self, dataLine):
        dataLine = self.encrypt(dataLine)
        self._logger.log(dataLine)

    def encrypt(self, dataLine):
        dataLine = dataLine[-1] + dataLine[:-1]
        return dataLine
# End of class

class HTMLLogger(LoggerDecorator):
    def __init__(self, logger):
        LoggerDecorator.__init__(self, logger)

    def log(self, dataLine):
        dataLine = self.makeHTML(dataLine)
        self._logger.log(dataLine)

    def makeHTML(self, dataLine):
        dataLine = "<HTML><BODY>" + "<b>" + dataLine + "</b>" + "</BODY></HTML>"
        return dataLine
# End of class
