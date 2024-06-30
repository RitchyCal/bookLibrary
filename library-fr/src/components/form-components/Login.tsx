import { FormControl } from '@mui/base/FormControl';
import { Box, Button, Container, FormLabel } from '@mui/material';
import { useForm } from 'react-hook-form';
import './form.css';
import { FormInputText } from './FormInputText';
interface IFormInput {
    userNameValue: string;
    passwordValue: string;
};
const defaultValues = {
    usernameValue: "",
    passwordValue: "",
};
const Login = () => {
    const { handleSubmit, control, setValue } = useForm<IFormInput>({
        defaultValues: defaultValues,
    });

    const onSubmit = (data: IFormInput) => console.log(data);

    return (
        <Container className='loginForm'>
                    <FormControl className='form' >
                        <FormLabel>
                            Login
                        </FormLabel>
                        <FormInputText name='usernameValue' control={control} label='Username' />
                        <FormInputText name='passwordValue' control={control} label='Password' />
                        <Button onClick={handleSubmit(onSubmit)}>Login</Button>
                    </FormControl>
        </Container>
    )
}

export default Login;