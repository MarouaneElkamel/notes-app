import { INote } from 'app/shared/model/note.model';

export interface ITag {
  id?: number;
  name?: string;
  notes?: INote[] | null;
}

export const defaultValue: Readonly<ITag> = {};
