/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTException;

/**
 *
 * @author LouiseB
 */
class ValidationErrorException extends Exception
{

    public ValidationErrorException()
    {
    }

    public ValidationErrorException(String message)
    {
        super(message);
    }
    
    
}
