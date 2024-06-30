// src/form-component/FormInputText.tsx
import { Controller } from "react-hook-form";
import TextField from "@mui/material/TextField";
import { FormInputProps } from "./FormInputProps";
import { Container, InputLabel } from "@mui/material";
export const FormInputText = ({ name, control, label }: FormInputProps) => {
    return (
        <Controller
            name={name}
            control={control}
            render={({
                field: { onChange, value },
                fieldState: { error },
                formState,
            }) => (
                <div style={{paddingLeft: 0}}>
                <InputLabel htmlFor={label}>{label}</InputLabel>
                <TextField
                    helperText={error ? error.message : null}
                    size="small"
                    error={!!error}
                    onChange={onChange}
                    value={value}
                    fullWidth
                    variant="outlined"
                    id={label}
                />
                </div>
            )}
        />
    );
};