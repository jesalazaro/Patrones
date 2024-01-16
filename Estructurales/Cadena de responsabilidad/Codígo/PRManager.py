# "Chain of Responsibility" example.
# This example was elaborated from Partha Kuchana's book "Software Architecture Design Patterns in Java" by Alvaro Abril. Examined and
# adapted with academic purposes by Henry Alberto Diosa

from PRHandler import *
from PurchaseRequest import *
class PRManager():

    def __init__(self):
        
      self.__branchManager = BranchManager("Robin")
      self.__regionalDirector = RegionalDirector("Oscar")
      self.__vicePresident = VicePresident("Kate")
      self.__coo = PresidentCOO("Drew")
      
    def createAuthorizationFlow(self):

      self.__branchManager.setNextHandler(self.__regionalDirector)
      self.__regionalDirector.setNextHandler(self.__vicePresident)
      self.__vicePresident.setNextHandler(self.__coo)

    def getBranchManager(self):
        return self.__branchManager
      
#End of class


def main():
    manager = PRManager()
    manager.createAuthorizationFlow()

    branchManager = manager.getBranchManager()

    request = PurchaseRequest(1, "Office Supplies", 10000)
    branchManager.authorize(request) 

    request = PurchaseRequest(2, "HardWare Procurement", 175000)
    branchManager.authorize(request)

    request = PurchaseRequest(3, "AD Campaign", 800000)
    branchManager.authorize(request)


if __name__== "__main__":
      main()



      
    
    
   

