import { AppBar, Toolbar, Typography } from "@mui/material";
import LibraryBooksIcon from '@mui/icons-material/LibraryBooks';

const LibraryNavBar = () => {
    return (
        <>
        <AppBar>
            <Toolbar>
                <LibraryBooksIcon/>
                <Typography>
                    Library
                </Typography>
            </Toolbar>
        </AppBar>
            
        </>
    );
}

export default LibraryNavBar;