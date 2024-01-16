# "Decorator" example.
# This example was elaborated from Partha Kuchana's example of his book "Software Architecture Design Patterns in Java" by Jefferson Jiménez and
# adapted by Henry Alberto Diosa
from tkinter import *
from tkinter import ttk
from Factories import *
from Decorator import *

class LoggerUI(Toplevel):
    FILE_LOGGER="File logger"
    CONSOLE_LOGGER="Console logger"
    HTML_LOGGER="Make HTML"
    ENCRYPT_LOGGER="Encrypt"
    LOG_MESSAGE="Log message"
    EXIT="Exit"
    
    def __init__(self, master):
        Toplevel.__init__(self,master)

        self.__lblMessage = Label(self,text="Message to log: ")
        self.__lblInfo = Label(self)

        self.__txtMessage = Entry(self)
        
        self.__cmbLoggers = ttk.Combobox(self, state="readonly")
        self.__cmbLoggers["values"]=[LoggerUI.FILE_LOGGER,LoggerUI.CONSOLE_LOGGER]
        self.__cmbLoggers.current(0)

        self.__cmbDecorators = ttk.Combobox(self, state="readonly")
        self.__cmbDecorators["values"]=[LoggerUI.HTML_LOGGER,LoggerUI.ENCRYPT_LOGGER]
        self.__cmbDecorators.current(0)
        
        self.__btnLog = Button(self,text=LoggerUI.LOG_MESSAGE)
        self.__btnExit = Button(self,text=LoggerUI.EXIT)

        self.__lblMessage.grid(row=1,column=1,padx=10,pady=10)
        self.__txtMessage.grid(row=1,column=2,padx=10,pady=10)
        self.__cmbLoggers.grid(row=2,column=1,padx=10,pady=10)
        self.__cmbDecorators.grid(row=2,column=2,padx=10,pady=10)
        self.__lblInfo.grid(row=3,column=1,padx=10,pady=10)
        self.__btnLog.grid(row=4,column=1,padx=10,pady=10)
        self.__btnExit.grid(row=4,column=2,padx=10,pady=10)
    def getMessageToLog(self):
        return self.__txtMessage.get()
    def getSelectedLogger(self):
        return self.__cmbLoggers.get()
    def getSelectedDecorator(self):
        return self.__cmbDecorators.get()
    def getBtnLog(self):
        return self.__btnLog
    def getBtnExit(self):
        return self.__btnExit
    def setInfo(self,msg):
        self.__lblInfo.configure(text=msg)
#End of class

class ButtonHandler():
    def __init__(self,root):
        self.__root=root
        self.__frame=LoggerUI(root)
        self.__frame.getBtnLog().configure(command=self.eventLog)
        self.__frame.getBtnExit().configure(command=self.eventExit)
    def eventLog(self):
        lf=LoggerFactory()
        typeL=self.__frame.getSelectedLogger()
        l=lf.getLogger(typeL)

        ld=DecoratorFactory()
        typeD=self.__frame.getSelectedDecorator()
        logger=ld.getDecorator(typeD,l)
        
        msg=self.__frame.getMessageToLog()
        
        try:
            logger.log(msg)
            self.__frame.setInfo("Log Successfully")
        except:
            self.__frame.setInfo("Error to log")
    def eventExit(self):
        self.__frame.destroy()
        self.__root.destroy()
#End of class



# Main function
def main():
    root = Tk()
    root.withdraw()
    app = ButtonHandler(root)
    root.mainloop()

if __name__=="__main__":
    main()
    #app.frame.mainloop()
    #root.destroy()
