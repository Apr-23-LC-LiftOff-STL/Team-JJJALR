export interface ProfileEdit {
id: number;
firstName: string;
lastName: string;
displayName: string;
email: string;
location: string;
picUrl: string;
status: string;
bio: string;
}

export interface UpdatePic{
    id: number;
    picUrl: string;
}

export interface UpdateStatus{
    id: number;
    status: string;
}

export interface UpdateBio{
    id: number;
    bio: string;
}