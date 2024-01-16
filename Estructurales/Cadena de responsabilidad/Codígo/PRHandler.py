import abc
from abc import ABC

class PRHandler(ABC):

    __metaclass__ = abc.ABCMeta
    
    def __init__(self,name):
        self.__handlerName = name

    def getName(self):
        return self.__handlerName

    def getNextHandler(self):
        return self.__nextHandler
    
    def setNextHandler(self,handler):
        self.__nextHandler = handler
        
    @abc.abstractmethod
    def authorize(self, request):
        raise NotImplementedError()
    
class BranchManager(PRHandler):
    LIMIT = 25000

    def __init__(self,name):
        PRHandler.__init__(self,name)

    #Override method of PRHandler
    def authorize(self,request):
        amount = request.getAmount()

        if amount <= self.LIMIT:
            print("Branch Manager " + self.getName() + " has authorized the PR - " + request.toString())
            return True
        else:
            return self.getNextHandler().authorize(request)

class RegionalDirector(PRHandler):
    LIMIT = 100000

    def __init__(self,name):
        PRHandler.__init__(self,name)
        
    def authorize(self,request):
        amount = request.getAmount()

        if amount <= RegionalDirector.LIMIT:
            print("Regional Director " + self.getName() + " has authorized the PR - " + request.toString())
            return True
        else:
            return self.getNextHandler().authorize(request)

class VicePresident(PRHandler):
    LIMIT = 200000
    
    def __init__(self,name):
        PRHandler.__init__(self,name)

    def authorize(self,request):
        amount = request.getAmount()

        if amount <= VicePresident.LIMIT:
            print("V.P. " + self.getName() + " has authorized the PR - " + request.toString())
            return True
        else:
            return self.getNextHandler().authorize(request)

class PresidentCOO(PRHandler):
    LIMIT = 400000

    def __init__(self,name):
        PRHandler.__init__(self,name)
        
    def authorize(self,request):
        amount = request.getAmount()

        if amount <= PresidentCOO.LIMIT:
            print("President & COO " + self.getName() + " has authorized the PR - " + request.toString())
            return True
        else:
            print("PR - " + request.toString() + " couldn't be authorized. Executive Board needs to be consulted for approval \n" +
                         "Reason: Amount too large")
            return False
