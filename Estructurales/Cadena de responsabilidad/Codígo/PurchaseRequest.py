class PurchaseRequest():

    def __init__(self, id, desc, amt):
        self.__ID = id
        self.__description = desc
        self.__amount = amt

    def getAmount(self):
        return self.__amount

    def toString(self):
        return str(self.__ID) + ":" + self.__description

# End of class