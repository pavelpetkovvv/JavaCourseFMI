package Encryption;

public class CipherMethod {


    public CipherMethod() {
        Encryption encryption = new Encryption();
        callBackFtn = encryption.getMonoCipher();
    }

    IEncryptable callBackFtn;

    public String encryptText(String plainText, String cipher) {
        return callBackFtn.encrypt(plainText, cipher);
    }

    public String decryptText(String cipherText, String cipher){
        return callBackFtn.decrypt(cipherText, cipher);
    }


}
