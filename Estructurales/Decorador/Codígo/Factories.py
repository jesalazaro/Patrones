#Factories required
from LoggerUI import *
from Decorator import *
#Logger factory
class LoggerFactory:
    def getLogger(self,typeL):
        if typeL==LoggerUI.FILE_LOGGER:
            return FileLogger.getFileLogger()
        else:
            return ConsoleLogger()
#Decorators factory
class DecoratorFactory:
    def getDecorator(self,typeD,logger):
        if typeD==LoggerUI.HTML_LOGGER: 
            return HTMLLogger(logger)  #se envia l 
        else:
            return EncryptLogger(logger)
#End of classes